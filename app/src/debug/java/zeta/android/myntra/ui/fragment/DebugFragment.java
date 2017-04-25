package zeta.android.myntra.ui.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pedrovgs.lynx.LynxActivity;
import com.github.pedrovgs.lynx.LynxConfig;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.activity.presentation.DebugPresentation;
import zeta.android.myntra.ui.activity.presenter.DebugPresenter;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;

@ParametersAreNonnullByDefault
public class DebugFragment extends BaseNavigationFragment implements DebugPresentation {

    private Views mViews;

    @Inject
    public DebugPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.debug_inspection_tools_title)
        TextView title;

        @BindView(R.id.debug_switch_enable_stetho)
        SwitchCompat switchStetho;

        @BindView(R.id.debug_switch_enable_strict_mode)
        SwitchCompat switchStrictMode;

        @BindView(R.id.debug_switch_enable_tiny_dancer)
        SwitchCompat switchTinyDancer;

        @BindView(R.id.debug_switch_enable_leaky_canary)
        SwitchCompat switchLeakyCanary;

        @BindView(R.id.debug_inspection_tools_apply)
        Button inspectionToolApplyBtn;

        @BindView(R.id.debug_logging_level_spinner)
        Spinner loggingSpinner;

        @BindView(R.id.debug_logging_apply)
        Button loggingToolApplyBtn;

        @BindView(R.id.debug_capture_logs)
        Button captureLogs;

        Views(View root) {
            super(root);
        }
    }

    public static DebugFragment newInstance() {
        return new DebugFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.debugComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_debug, container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        registerClickListener();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unRegisterClickListener();
        mViews.clear();
        mViews = null;
        mPresenter.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter = null;
    }

    @Override
    public void initLoggerSpinnerAdapter(String[] loggerSpinnerData) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,
                loggerSpinnerData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mViews.loggingSpinner.setAdapter(adapter);
    }

    @Override
    public void setLoggerSpinnerSelected(int position) {
        mViews.loggingSpinner.setSelection(position);
    }

    @Override
    public void setEnableLoggingToolsApplyButton(boolean enableLoggingToolsApplyButton) {
        mViews.loggingToolApplyBtn.setEnabled(enableLoggingToolsApplyButton);
    }

    @Override
    public void setEnableStetho(boolean enableStetho) {
        mViews.switchStetho.setChecked(enableStetho);
    }

    @Override
    public void setEnableStrictMode(boolean enableStrictMode) {
        mViews.switchStrictMode.setChecked(enableStrictMode);
    }

    @Override
    public void setEnableTinyDancer(boolean enableTinyDancer) {
        mViews.switchTinyDancer.setChecked(enableTinyDancer);
    }

    @Override
    public void setEnableLeakyCanary(boolean enableLeakyCanary) {
        mViews.switchLeakyCanary.setChecked(enableLeakyCanary);
    }

    @Override
    public void setEnableInspectionToolsApplyButton(boolean enable) {
        mViews.inspectionToolApplyBtn.setEnabled(enable);
    }

    @Override
    public void showToastMessage(@StringRes int message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void restartApp(long delay) {
        restartAppInternal(delay);
    }

    @Override
    public void showLoggingConsole(LynxConfig config) {
        Intent lynxActivityIntent = LynxActivity.getIntent(getContext(), config);
        startActivity(lynxActivityIntent);
    }

    private void registerClickListener() {
        mViews.switchStetho.setOnCheckedChangeListener((compoundButton, isChecked) -> mPresenter.setSethoEnabled(isChecked));
        mViews.switchStrictMode.setOnCheckedChangeListener((compoundButton, isChecked) -> mPresenter.setStrictModeEnabled(isChecked));
        mViews.switchTinyDancer.setOnCheckedChangeListener((compoundButton, isChecked) -> mPresenter.setTinyDancerEnabled(isChecked));
        mViews.switchLeakyCanary.setOnCheckedChangeListener((compoundButton, isChecked) -> mPresenter.setLeakyCanaryEnabled(isChecked));
        mViews.inspectionToolApplyBtn.setOnClickListener(view -> mPresenter.applyInspectionToolsSettings());
        mViews.loggingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mPresenter.setLoggingLevelSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //no op
            }
        });
        mViews.loggingToolApplyBtn.setOnClickListener(view -> mPresenter.applyLoggingSettings());
        mViews.captureLogs.setOnClickListener(view -> mPresenter.showLoggingConsole());
    }

    private void unRegisterClickListener() {
        mViews.switchStetho.setOnCheckedChangeListener(null);
        mViews.switchStrictMode.setOnCheckedChangeListener(null);
        mViews.switchTinyDancer.setOnCheckedChangeListener(null);
        mViews.switchLeakyCanary.setOnCheckedChangeListener(null);
        mViews.inspectionToolApplyBtn.setOnClickListener(null);
        mViews.loggingSpinner.setOnItemSelectedListener(null);
        mViews.loggingToolApplyBtn.setOnClickListener(null);
        mViews.captureLogs.setOnClickListener(null);
    }

    private void restartAppInternal(long delayMillis) {
        if (mViews == null) {
            return;
        }
        PendingIntent i = PendingIntent.getActivity(
                getActivity().getBaseContext(), 0,
                new Intent(getActivity().getIntent()),
                PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mgr = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + delayMillis, i);
        //noinspection ConstantConditions
        getView().postDelayed(() -> android.os.Process.killProcess(android.os.Process.myPid()), delayMillis);
    }

}
